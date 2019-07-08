package id;

/**
 * 雪花算法
 * @author Gentle
 */
public class SnowFlakeGenerator {
 
    public static class Factory {
        /**
         * 每一部分占用位数的默认值
         * 机器标识占用的位数
         */
        private final static int DEFAULT_MACHINE_BIT_NUM = 5;
        /**数据中心占用的位数**/
        private final static int DEFAULT_IDC_BIT_NUM = 5;
 
        private int machineBitNum;

        private int idcBitNum;

        public Factory() {
            this.idcBitNum = DEFAULT_IDC_BIT_NUM;
            this.machineBitNum = DEFAULT_MACHINE_BIT_NUM;
        }
 
        public Factory(int machineBitNum, int idcBitNum) {
            this.idcBitNum = idcBitNum;
            this.machineBitNum = machineBitNum;
        }

        /**
         *
         * @param idcId 机器 id
         * @param machineId  数据中心 id
         * @return
         */
        public SnowFlakeGenerator create(long idcId, long machineId) {
            return new SnowFlakeGenerator(this.idcBitNum, this.machineBitNum, idcId, machineId);
        }
    }
 
    /**
     * 起始的时间戳
     * 作者写代码时的时间戳
     */
    private final static long START_STAMP = 1561182965589L;
 
    /**
     * 可分配的位数
     */
    private final static int REMAIN_BIT_NUM = 22;
 
    /**
     * idc编号
     */
    private long idcId;
 
    /**
     * 机器编号
     */
    private long machineId;
 
    /**
     * 当前序列号
     */
    private long sequence = 0L;
 
    /**
     * 上次最新时间戳
     */
    private long lastStamp = -1L;
 
    /**
     * idc偏移量：一次计算出，避免重复计算
     */
    private int idcBitLeftOffset;
 
    /**
     * 机器id偏移量：一次计算出，避免重复计算
     */
    private int machineBitLeftOffset;
 
    /**
     * 时间戳偏移量：一次计算出，避免重复计算
     */
    private int timestampBitLeftOffset;
 
    /**
     * 最大序列值：一次计算出，避免重复计算
     */
    private int maxSequenceValue;

    /**
     *
     * @param idcBitNum  数据中心占用的位数
     * @param machineBitNum 机器标识占用的位数
     * @param idcId idc编号
     * @param machineId 机器编号
     */
    private SnowFlakeGenerator(int idcBitNum, int machineBitNum, long idcId, long machineId) {
        //sequenceBitNum =12
        int sequenceBitNum = REMAIN_BIT_NUM - idcBitNum - machineBitNum;
 
        if (idcBitNum <= 0 || machineBitNum <= 0 || sequenceBitNum <= 0) {
            throw new IllegalArgumentException("error bit number");
        }
        /**
         * 最大序列值 使用非运算
         * -1 << 2 二进制码是 10000001  得出十进制是 -4
         * 非运算过后，是 -4 的绝对值 -1 得出是 3
         */
        this.maxSequenceValue = ~(-1 << sequenceBitNum);
        //机器id偏移量 = 机器标识占用的位数
        machineBitLeftOffset = sequenceBitNum;
        //idc 偏移量 = 数据中心占用的位数 + 机器标识占用的位数
        idcBitLeftOffset = idcBitNum + sequenceBitNum;
        //时间戳偏移量 = 数据中心占用的位数 + 机器标识占用的位数 + 机器标识占用的位数
        timestampBitLeftOffset = idcBitNum + machineBitNum + sequenceBitNum;
 
        this.idcId = idcId;
        this.machineId = machineId;
    }
 
    /**
     * 产生下一个ID
     */
    public synchronized long nextId() {
        long currentStamp = getTimeMill();
        if (currentStamp < lastStamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastStamp - currentStamp));
        }
 
        //新的毫秒，序列从0开始，否则序列自增
        if (currentStamp == lastStamp) {
            sequence = (sequence + 1) & this.maxSequenceValue;
            if (sequence == 0L) {
                //Twitter源代码中的逻辑是循环，直到下一个毫秒
                lastStamp = tilNextMillis();
            }
        } else {
            //设置当前序列号当前序列号
            sequence = 0L;
        }
        //设置最后的时间
        lastStamp = currentStamp;
 
        return (currentStamp - START_STAMP) << timestampBitLeftOffset | idcId << idcBitLeftOffset | machineId << machineBitLeftOffset | sequence;
    }

    /**
     * 获取时间戳
     * @return
     */
    private long getTimeMill() {
        return System.currentTimeMillis();
    }

    /**
     * 获取下一个毫秒
     * @return
     */
    private long tilNextMillis() {
        //拿到当前毫秒时间戳
        long timestamp = getTimeMill();
        //拿到下一个毫秒
        while (timestamp <= lastStamp) {
            timestamp = getTimeMill();
        }
        return timestamp;
    }


    public static void main(String[] args) {
        int i1 = ~(-1 << 12);
        System.out.println(i1);
        Factory factory = new Factory();
        SnowFlakeGenerator snowFlakeGenerator = factory.create(1, 1);
        System.out.println(snowFlakeGenerator.nextId());

    }
}