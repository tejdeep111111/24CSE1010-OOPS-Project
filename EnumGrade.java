public enum EnumGrade {
    //10,9,8,7,6,FAIL,NoAttendence
    A(10),B(9),C(8),D(7),P(6),F(0),W(-1);
    private final int value;
    EnumGrade(int value) {
        this.value=value;
    }
    public int getValueOfGrade(EnumGrade grade) {
        return grade.value;
    }
}
