package com.demo.sales.constants;

public final class DbConstants {

    private DbConstants() {
    }

    /** Shared by every Sales chart: only regions that are switched on. */
    public static final String FILTER_ACTIVE_REGION =
            " AND s.region_cd IN (SELECT r.region_cd FROM D_REGION r WHERE r.active_flg = 'Y') ";
}
