package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
class AccessibilityNodeInfoCompatKitKat {
    AccessibilityNodeInfoCompatKitKat() {
    }

    static int getLiveRegion(Object info) {
        return ((AccessibilityNodeInfo) info).getLiveRegion();
    }

    static void setLiveRegion(Object info, int mode) {
        ((AccessibilityNodeInfo) info).setLiveRegion(mode);
    }

    static Object getCollectionInfo(Object info) {
        return ((AccessibilityNodeInfo) info).getCollectionInfo();
    }

    static Object getCollectionItemInfo(Object info) {
        return ((AccessibilityNodeInfo) info).getCollectionItemInfo();
    }

    public static void setCollectionInfo(Object info, Object collectionInfo) {
        ((AccessibilityNodeInfo) info).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) collectionInfo);
    }

    public static void setCollectionItemInfo(Object info, Object collectionItemInfo) {
        ((AccessibilityNodeInfo) info).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) collectionItemInfo);
    }

    static Object getRangeInfo(Object info) {
        return ((AccessibilityNodeInfo) info).getRangeInfo();
    }

    public static Object obtainCollectionInfo(int rowCount, int columnCount, boolean hierarchical, int selectionMode) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(rowCount, columnCount, hierarchical);
    }

    public static Object obtainCollectionItemInfo(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading);
    }

    static class CollectionInfo {
        CollectionInfo() {
        }

        static int getColumnCount(Object info) {
            return ((AccessibilityNodeInfo.CollectionInfo) info).getColumnCount();
        }

        static int getRowCount(Object info) {
            return ((AccessibilityNodeInfo.CollectionInfo) info).getRowCount();
        }

        static boolean isHierarchical(Object info) {
            return ((AccessibilityNodeInfo.CollectionInfo) info).isHierarchical();
        }
    }

    static class CollectionItemInfo {
        CollectionItemInfo() {
        }

        static int getColumnIndex(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).getColumnIndex();
        }

        static int getColumnSpan(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).getColumnSpan();
        }

        static int getRowIndex(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).getRowIndex();
        }

        static int getRowSpan(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).getRowSpan();
        }

        static boolean isHeading(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).isHeading();
        }
    }

    static class RangeInfo {
        RangeInfo() {
        }

        static float getCurrent(Object info) {
            return ((AccessibilityNodeInfo.RangeInfo) info).getCurrent();
        }

        static float getMax(Object info) {
            return ((AccessibilityNodeInfo.RangeInfo) info).getMax();
        }

        static float getMin(Object info) {
            return ((AccessibilityNodeInfo.RangeInfo) info).getMin();
        }

        static int getType(Object info) {
            return ((AccessibilityNodeInfo.RangeInfo) info).getType();
        }
    }
}
