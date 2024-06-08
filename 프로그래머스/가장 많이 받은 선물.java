
import java.util.*;

class Solution {

    public int solution(String[] friends, String[] gifts) {
        Map<String, Person> personMap = new HashMap<>();
        for (String name : friends) {
            Person person = new Person(name);
            personMap.put(name, person);
        }
        for (String gift : gifts) {
            String[] tempArr = gift.split(" ");
            Person giver = personMap.get(tempArr[0]);
            Person getter = personMap.get(tempArr[1]);

            giver.giveCount = giver.giveCount + 1;
            giver.giveCountMap.merge(getter.name, 1, (oldValue, newValue) -> oldValue + 1);
            getter.getCount = getter.getCount + 1;
        }
        
        Map<String, Integer> nextMonthCountMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            Person targetPerson = personMap.get(friends[i]);
            for (int j = i + 1; j < friends.length; j++) {
                Person comparePerson = personMap.get(friends[j]);
                int giveCount = targetPerson.giveCountMap.getOrDefault(comparePerson.name, 0);
                int getCount = comparePerson.giveCountMap.getOrDefault(targetPerson.name, 0);
                if (giveCount > getCount) {
                    nextMonthCountMap.merge(targetPerson.name, 1, (oldValue, newValue) -> oldValue + 1);
                } else if (giveCount < getCount) {
                    nextMonthCountMap.merge(comparePerson.name, 1, (oldValue, newValue) -> oldValue + 1);
                } else {
                    if (targetPerson.getGiftScore() > comparePerson.getGiftScore()) {
                        nextMonthCountMap.merge(targetPerson.name, 1, (oldValue, newValue) -> oldValue + 1);
                    } else if (targetPerson.getGiftScore() < comparePerson.getGiftScore()) {
                        nextMonthCountMap.merge(comparePerson.name, 1, (oldValue, newValue) -> oldValue + 1);
                    }
                }
            }
        }
        return nextMonthCountMap.values()
                .stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public static class Person {

        private String name;
        private int getCount;
        private int giveCount;
        private Map<String, Integer> giveCountMap;

        public Person(String name) {
            this.name = name;
            this.getCount = 0;
            this.giveCount = 0;
            this.giveCountMap = new HashMap<>();
        }

        public int getGiftScore() {
            return this.giveCount - this.getCount;
        }
    }
}