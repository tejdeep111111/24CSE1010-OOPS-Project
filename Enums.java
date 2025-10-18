
public class Enums {
    
    public enum EnumRole {
        STUDENT,PROFESSOR;
        @Override
        public String toString() {
            return name().charAt(0)+name().substring(1).toLowerCase();
        }
    }
    public enum EnumGrade {
        //10,9,8,7,6,5,FAIL,NoAttendence
        S(10),A(9),B(8),C(7),D(6),P(5),F(0),W(-1);
        private final int value;
        EnumGrade(int value) {
            this.value=value;
        }
        public int getValueOfGrade(EnumGrade grade) {
            return grade.value;
        }
    }
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
        public static EnumSem getByNumber(int number) {
            for(EnumSem sem : EnumSem.values()) {
                if(sem.number==number) {
                    return sem;
                }
            }
            return null;
        }
    }
}
