import java.util.*;

class Student {
    String name;
    int score;
    
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class 선택_정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        List<Student> student_list = new ArrayList<>();
        
        Student temp_student;
        int idx;
        
        for(int i=0;i<N;i++) {
            student_list.add(new Student(sc.next(), sc.nextInt()));
        }
        
        for(int i=0;i<N-1;i++) {
            idx = i;
            for(int j=i+1;j<N;j++) {
                if(student_list.get(i).score > student_list.get(j).score) {
                    idx = j;
                }
            }
            
            temp_student = student_list.get(idx);
            student_list.set(idx, student_list.get(i));
            student_list.set(i, temp_student);
        }
        
        for(Student s:student_list) {
            System.out.print(s.name+ " ");
        }
        
    }
}