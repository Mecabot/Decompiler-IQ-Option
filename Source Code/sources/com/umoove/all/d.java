package com.umoove.all;

/* compiled from: NativeMessage */
class d {
    int a;
    int b;
    int c;
    int d;
    int e;
    double ejf;
    double ejg;
    float ejh;
    boolean eji = false;
    int f;
    float g;
    float h;
    int i;
    int j;
    float m;
    float n;
    float o;
    int p;
    boolean q;
    float s;
    float t;
    int u;
    private int w = -1;

    public d(int i) {
        this.w = i;
    }

    public int a() {
        return this.w;
    }

    public String toString() {
        switch (this.w) {
            case 0:
                return "init vals";
            case 1:
                return "reset";
            case 2:
                return "start tracking";
            case 3:
                return "stop tracking";
            case 4:
                return "SET_DISPLAY_WINDOW";
            case 5:
                return "destroy";
            case 7:
                return "calibrate gaze";
            case 8:
                return "INIT_HEAD_POSITION";
            case 9:
                return "INIT_HEAD_MOVEMENT";
            case 10:
                return "INIT_IRIS";
            case 11:
                return "SET_IRIS_TRACKING_MODE";
            case 12:
                return "SET_IRIS_RADIUS";
            case 13:
                return "SET_EYE_BALL_RADIUS";
            case 14:
                return "SET_DISTANCE_BETWEEN_EYES";
            default:
                return "unknown native message type";
        }
    }
}
