import java.util.*;

interface CompareChar{

    Character[] alphb = {'a', 'b', 'c', 'd','e','f','g','h', 'j','m',
                        'n','o','p','q','r','s','t','u','v','x','y','z'};

    HashMap<Character, Integer> alphaMap = new HashMap<>();

    public Integer compare(Character a, Character b);

}