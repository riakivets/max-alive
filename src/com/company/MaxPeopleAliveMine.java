package com.company;

import java.util.*;

public class MaxPeopleAliveMine {
    private static class Person {
        private Integer birth;
        private Integer death;

        public Person(Integer birth, Integer death) {
            this.birth = birth;
            this.death = death;
        }

        public Integer getBirth() {
            return birth;
        }

        public Integer getDeath() {
            return death;
        }
    }

    public Integer findMaxYear(List<Person> personsToFilter) {
        Map<Integer, Integer> personYears = getYearsInMapStructure(personsToFilter);
        int maxYear = 0;
        int maxValue = 0;
        int currentValue = 0;

        for (Map.Entry<Integer, Integer> entry : personYears.entrySet()) {
            Integer year = entry.getKey();
            int yearValue = entry.getValue();
            currentValue = currentValue + yearValue;

            if (currentValue > maxValue) {
                maxYear = year;
                maxValue = currentValue;
            }

        }

        return maxYear;
    }

    private Map<Integer, Integer> getYearsInMapStructure(List<Person> personsToFilter) {
        Map<Integer, Integer> personYears = new TreeMap<>();
        for (Person person : personsToFilter) {
            personYears.putIfAbsent(person.getBirth(), 0);
            personYears.put(person.getBirth(), personYears.get(person.getBirth()) + 1);

            int deathKey = person.getDeath() + 1;
            personYears.putIfAbsent(deathKey, 0);
            personYears.put(deathKey, personYears.get(deathKey) - 1);
        }
        return personYears;
    }

    public static void main(String[] args) {
        List<MaxPeopleAliveMine.Person> people = new ArrayList<>();
        MaxPeopleAliveMine.Person p1 = new MaxPeopleAliveMine.Person(1982, 2017);
        MaxPeopleAliveMine.Person p2 = new MaxPeopleAliveMine.Person(1923, 2004);
        MaxPeopleAliveMine.Person p3 = new MaxPeopleAliveMine.Person(1988, 2015);
        MaxPeopleAliveMine.Person p4 = new MaxPeopleAliveMine.Person(1910, 1988);
        MaxPeopleAliveMine.Person p5 = new MaxPeopleAliveMine.Person(1990, 2005);
        MaxPeopleAliveMine.Person p6 = new MaxPeopleAliveMine.Person(2004, 2010);
        Collections.addAll(people, p1, p2, p3, p4, p5, p6);
        System.out.println(new MaxPeopleAliveMine().findMaxYear(people));
    }
}
