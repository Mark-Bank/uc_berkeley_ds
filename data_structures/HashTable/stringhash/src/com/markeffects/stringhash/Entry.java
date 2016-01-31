package com.markeffects.stringhash;

/**
 * Mark Bank
 * description
 * markbank@markeffects.com
 * 1/30/2016
 */
class Entry {
  private String key;
  private String val;

  Entry(String key, String val) {
    this.key = key;
    this.val = val;
  }

  public String getKey() {
    return key;
  }

  public String getVal() {
    return val;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Entry)) {
      return false;
    }

    if (obj == this) {
      return true;
    }

    Entry rhs = (Entry) obj;

    return ((this.key.equals(rhs.key)) && (this.val.equals(rhs.val)));
  }
}
