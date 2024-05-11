import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public static final Comparator<Map.Entry<PersonType, Integer>> COMPARATOR = Comparator.comparing((Map.Entry<PersonType, Integer> e) -> e.getValue(), Comparator.reverseOrder())
            .thenComparing(e -> e.getKey().name());
    
    public String solution(String[] survey, int[] choices) {
        Map<PersonType, Integer> personTypeScoreMap = Arrays.stream(PersonType.values())
                .collect(Collectors.toMap(p -> p, p -> 0));

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            PersonType disAgree = PersonType.valueOf(survey[i].split("")[0]);
            PersonType agree = PersonType.valueOf(survey[i].split("")[1]);
            if (choice == 1) {
                personTypeScoreMap.merge(disAgree, 3, (exist, replace) -> exist + 3);
                continue;
            }
            if (choice == 2) {
                personTypeScoreMap.merge(disAgree, 2, (exist, replace) -> exist + 2);
                continue;
            }
            if (choice == 3) {
                personTypeScoreMap.merge(disAgree, 1, (exist, replace) -> exist + 1);
                continue;
            }
            if (choice == 4) {
                continue;
            }
            if (choice == 5) {
                personTypeScoreMap.merge(agree, 1, (exist, replace) -> exist + 1);
                continue;
            }
            if (choice == 6) {
                personTypeScoreMap.merge(agree, 2, (exist, replace) -> exist + 2);
                continue;
            }
            if (choice == 7) {
                personTypeScoreMap.merge(agree, 3, (exist, replace) -> exist + 3);
                continue;
            }
        }
        return decidePersonType(1, personTypeScoreMap) +
                decidePersonType(2, personTypeScoreMap) +
                decidePersonType(3, personTypeScoreMap) +
                decidePersonType(4, personTypeScoreMap);


    }
    private String decidePersonType(int num, Map<PersonType, Integer> personTypeScoreMap) {
        return personTypeScoreMap.entrySet()
                .stream()
                .filter(e -> e.getKey().getNum() == num)
                .sorted(COMPARATOR)
                .map(e -> e.getKey().name())
                .findFirst()
                .get();
    }

    enum PersonType {
        R(1),
        T(1),
        C(2),
        F(2),
        J(3),
        M(3),
        A(4),
        N(4);

        private final int num;

        PersonType(int num) {
            this.num = num;
        }

        public int getNum() {
            return this.num;
        }
    }
}