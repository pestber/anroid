package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* loaded from: classes.dex */
class AccessibilityNodeProviderCompatKitKat {

    interface AccessibilityNodeInfoBridge {
        Object createAccessibilityNodeInfo(int i);

        List<Object> findAccessibilityNodeInfosByText(String str, int i);

        Object findFocus(int i);

        boolean performAction(int i, int i2, Bundle bundle);
    }

    AccessibilityNodeProviderCompatKitKat() {
    }

    public static Object newAccessibilityNodeProviderBridge(final AccessibilityNodeInfoBridge bridge) {
        return new AccessibilityNodeProvider() { // from class: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.1
            @Override // android.view.accessibility.AccessibilityNodeProvider
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
                return (AccessibilityNodeInfo) bridge.createAccessibilityNodeInfo(virtualViewId);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text, int virtualViewId) {
                return bridge.findAccessibilityNodeInfosByText(text, virtualViewId);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public boolean performAction(int virtualViewId, int action, Bundle arguments) {
                return bridge.performAction(virtualViewId, action, arguments);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public AccessibilityNodeInfo findFocus(int focus) {
                return (AccessibilityNodeInfo) bridge.findFocus(focus);
            }
        };
    }
}
