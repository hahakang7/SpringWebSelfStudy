
    import javax.swing.text.html.HTML;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.time.Instant;
    import java.time.Year;
    import java.util.*;
    import java.util.stream.Stream;

    import static javax.swing.text.html.HTML.Attribute.N;

    public class Main {

        static Scanner sc = new Scanner(System.in);

        public static class Num {
            //순서
            int id;
            //입력값
            long value;
            Num(int id, long value) {
                this.id = id;
                this.value = value;
            }
        }

        public static void main(String[] args) {
            int N = sc.nextInt();
            int[] answer = new int[N];
            ArrayList<Num> arr = new ArrayList<Num>();

            //입력값과 순서를 list에 넣는다
            for (int i = 0; i < N; i++) {
                arr.add(new Num(i, sc.nextLong()));
            }
            //객체를 value로 정렬
            arr.sort(new Comparator<Num>() {
                @Override
                public int compare(Num o1, Num o2) {
                    return (int) (o1.value - o2.value);
                }
            });

            //범위까지의 중복인 수의 개수
            int dup = 0;
            for (int i = 0; i < arr.size(); i++) {
                //지금까지 봐온 중복의 개수는 다시 볼 필요가 없으므로 이전것과만 비교
                if (i != 0 && arr.get(i).value == arr.get(i - 1).value) {
                    dup++;
                }
                //자신보다 작은 수의 개수에서 중복개수를 제거
                answer[arr.get(i).id] = i - dup;

            }
            for(int num : answer) {
                System.out.print(num+" ");
            }

        }

    }


