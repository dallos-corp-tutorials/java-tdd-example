package co.com.java.tdd;

import co.com.java.tdd.exceptions.TriangleMalformedException;

import java.util.ArrayList;

public class Triangle {

    private ArrayList<Integer> sides = new ArrayList<Integer>();;

    enum TriangleType {
        ISOSCELES, SCALENE, EQUILATERAL
    }

    public Triangle(int a, int b, int c) throws TriangleMalformedException {
        if(a + b <= c || a + c <= b || b + c <= a){throw new TriangleMalformedException();}
        sides = new ArrayList<>();
        sides.add(a);
        sides.add(b);
        sides.add(c);
    }

    public TriangleType getType() {
        int count = (int) sides.stream().distinct().count();
        if(count == 1) return TriangleType.EQUILATERAL;
        if(count == 2) return TriangleType.ISOSCELES;
        return TriangleType.SCALENE;
    }

}
