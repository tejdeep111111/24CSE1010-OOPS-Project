public enum EnumGrade {
    //10,9,8,7,6,FAIL,NoAttendence
    S(10),A(9),B(8),C(7),D(6),P(5),F(0),W(-1);
    private final int value;
    EnumGrade(int value) {
        this.value=value;
    }
    public int getValueOfGrade(EnumGrade grade) {
        return grade.value;
    }
}
