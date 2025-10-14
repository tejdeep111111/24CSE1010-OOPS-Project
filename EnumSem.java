public enum EnumSem {
    //enum having values for each Enumerator
    SEMESTER_1(1),SEMESTER_2(2),SEMESTER_3(3),SEMESTER_4(4),SEMESTER_5(5),SEMESTER_6(6),SEMESTER_7(7),SEMESTER_8(8);
    //variable that stores the value of enum
    private final int number;
    //ENUM Constructor
    EnumSem(int num) {
        this.number=num;
    }
    @Override
    public String toString() {
        return name();
    }
    public EnumSem nextSemester() {
        for(EnumSem sem : EnumSem.values()) {
            if(sem.number==this.number+1) {
                return sem;
            }
        }
        return null;
    }
    public EnumSem getByNumber(int number) {
        for(EnumSem sem : EnumSem.values()) {
            if(sem.number==this.number) {
                return sem;
            }
        }
        return null;
    }
}
