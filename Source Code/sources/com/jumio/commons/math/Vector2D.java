package com.jumio.commons.math;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public Vector2D(float f, float f2, float f3, float f4) {
        this.x = (double) (f3 - f);
        this.y = (double) (f4 - f2);
    }

    protected Vector2D(Vector2D vector2D) {
        this.x = vector2D.x;
        this.y = vector2D.y;
    }

    public Vector2D scale(double d) {
        return new Vector2D(this.x * d, this.y * d);
    }

    public double length() {
        return Math.sqrt(Math.pow(this.x, 2.0d) + Math.pow(this.y, 2.0d));
    }

    public Vector2D unit() {
        Vector2D vector2D = new Vector2D();
        double length = length();
        vector2D.x = this.x / length;
        vector2D.y = this.y / length;
        return vector2D;
    }

    public boolean isUnit() {
        return length() == 1.0d;
    }

    public double angleDeg(Vector2D vector2D) {
        Vector2D unit = unit();
        Vector2D unit2 = vector2D.unit();
        if (equals(vector2D)) {
            return 0.0d;
        }
        return MathUtils.rad2deg(Math.acos(unit.dotProduct(unit2)));
    }

    public double angleDeg() {
        return angleDeg(new Vector2D(1.0d, 0.0d));
    }

    public double dotProduct(Vector2D vector2D) {
        return (this.x * vector2D.x) + (this.y * vector2D.y);
    }

    public Quadrant getQuadrant() {
        if (this.x >= 0.0d) {
            if (this.y >= 0.0d) {
                return Quadrant.UPPER_RIGHT;
            }
            return Quadrant.LOWER_RIGHT;
        } else if (this.y >= 0.0d) {
            return Quadrant.UPPER_LEFT;
        } else {
            return Quadrant.LOWER_LEFT;
        }
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double d) {
        this.x = d;
    }

    public void setY(double d) {
        this.y = d;
    }

    public Vector2D add(Vector2D vector2D) {
        Vector2D vector2D2 = new Vector2D(this);
        vector2D2.x += vector2D.x;
        vector2D2.y += vector2D.y;
        return vector2D2;
    }

    public Vector2D subtract(Vector2D vector2D) {
        Vector2D vector2D2 = new Vector2D(this);
        vector2D2.x -= vector2D.x;
        vector2D2.y -= vector2D.y;
        return vector2D2;
    }

    public Vector2D add(float f, float f2) {
        return add(new Vector2D((double) f, (double) f2));
    }

    public float getSlope() {
        return (float) (this.y / this.x);
    }

    public Vector2D getNormalRight() {
        return new Vector2D(this.y, -this.x);
    }

    public Vector2D getNormalLeft() {
        return new Vector2D(-this.y, this.x);
    }
}
