package com.astanait;

public enum Size {
    SMALL(10),
    MEDIUM(12),
    LARGE(16),
    EXTRA_LARGE(18);

    private final int diameterInches;

    Size(int diameterInches) {
        this.diameterInches = diameterInches;
    }

    public int getDiameterInches() {
        return diameterInches;
    }
}

