package fr.istic.vv;

import java.util.HashMap;

class Date implements Comparable<Date> {

    private static HashMap<Integer, Integer> nbJoursParMois = new HashMap<>(){{
        put(1, 31);
        put(2, 29);
        put(3, 31);
        put(4, 30);
        put(5, 31);
        put(6, 30);
        put(7, 31);
        put(8, 31);
        put(9, 30);
        put(10, 31);
        put(11, 30);
        put(12, 31);
    }};
    public int year;
    public int month;
    public int day;


    public Date(int day, int month, int year) throws Exception {
        if(!isValidDate(day, month, year)) throw new Exception() ;
        this.day = day ; this.month = month ; this.year = year ;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if(!isLeapYear(year) && month == 2){
            return (day <= 28 && day > 0);
        }
        else return month <= 12 && month > 0 && (day <= nbJoursParMois.get(month)) && day > 0 ;
    }

    public static boolean isLeapYear(int year) {
        return year%4 == 0;
    }

    public Date nextDate() throws Exception {
        if(this.day == 31 && this.month == 12){ // nouvel an
            return new Date(1, 1, this.year+1 );
        }
        else if(this.day == nbJoursParMois.get(this.month)) {
            return new Date(1,this.month+1, this.year);
        }
        else if(!isLeapYear(this.year) && this.day == 28 && this.month ==2 ) return new Date(1,3,this.year);
        else return new Date(this.day+1, this.month, this.year);
    }

    public Date previousDate() throws Exception {
        if(this.day == 1 && this.month == 1){ // nouvel an
            return new Date(31, 12, this.year-1 );
        }
        else if(this.day == 1) {
            if (this.month == 3 && !isLeapYear(this.year)) return new Date(28, 2, this.year); // 1 mars leap year
            else return new Date(nbJoursParMois.get(this.month-1),this.month-1, this.year); // premier jour de chaque mois
        }
        else return new Date(this.day-1, this.month, this.year);
    }

//date.compareTo(other) renvoie un entier positif si date est postérieure à other
//date.compareTo(other) renvoie un entier négatif si date est antérieure à other
//date.compareTo(other) renvoie 0 si date et other représentent la même date

    public int compareTo(Date other) {
        if((this.year < other.year) ||
                ((this.year == other.year) &&
                        ((this.month < other.month) ||
                                ((this.month == other.month) && this.day < other.day)))) return -1 ;
        else if((this.year > other.year) ||
                    ((this.year == other.year) &&
                            ((this.month > other.month) ||
                                    ((this.month == other.month) && this.day > other.day)))) return 1 ;
        else return 0;
    }

}