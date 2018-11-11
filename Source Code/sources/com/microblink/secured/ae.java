package com.microblink.secured;

/* compiled from: line */
public final class ae {
    private int dYk = -1;
    private int dYl = -1;
    private int dYm = -1;

    public ae(String str) {
        if (str == null) {
            throw new NullPointerException("Cannot parse null version string!");
        }
        String[] split = str.split("\\.");
        if (split.length == 0) {
            StringBuilder stringBuilder = new StringBuilder("Invalid version string ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (split.length > 0) {
            this.dYk = Integer.parseInt(split[0]);
            if (split.length >= 2) {
                this.dYl = Integer.parseInt(split[1]);
                if (split.length >= 3) {
                    this.dYm = Integer.parseInt(split[2]);
                }
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dYk);
        if (this.dYl != -1) {
            stringBuilder.append('.');
            stringBuilder.append(this.dYl);
            if (this.dYm != -1) {
                stringBuilder.append('.');
                stringBuilder.append(this.dYm);
            }
        }
        return stringBuilder.toString();
    }

    public final boolean a(ae aeVar) {
        if (aeVar == null) {
            throw new NullPointerException("Cannot compare with null version!");
        } else if (this.dYk < aeVar.dYk) {
            return false;
        } else {
            if (this.dYk > aeVar.dYk) {
                return true;
            }
            if (this.dYl == -1) {
                return false;
            }
            if (aeVar.dYl == -1) {
                if (this.dYl == 0) {
                    return false;
                }
                return true;
            } else if (this.dYl < aeVar.dYl) {
                return false;
            } else {
                if (this.dYl > aeVar.dYl) {
                    return true;
                }
                if (this.dYm == -1) {
                    return false;
                }
                if (aeVar.dYm == -1) {
                    if (this.dYm == 0) {
                        return false;
                    }
                    return true;
                } else if (this.dYm > aeVar.dYm) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public final boolean b(ae aeVar) {
        if (aeVar == null) {
            throw new NullPointerException("Cannot compare with null version!");
        } else if (this.dYk < aeVar.dYk) {
            return false;
        } else {
            if (this.dYk > aeVar.dYk) {
                return true;
            }
            if (this.dYl == -1) {
                if (aeVar.dYl == -1 || aeVar.dYl == 0) {
                    return true;
                }
                return false;
            } else if (aeVar.dYl == -1) {
                return true;
            } else {
                if (this.dYl < aeVar.dYl) {
                    return false;
                }
                if (this.dYl > aeVar.dYl) {
                    return true;
                }
                if (this.dYm == -1) {
                    if (aeVar.dYm == -1 || aeVar.dYm == 0) {
                        return true;
                    }
                    return false;
                } else if (aeVar.dYm != -1 && this.dYm < aeVar.dYm) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
}
