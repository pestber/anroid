package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import java.io.File;

/* loaded from: classes.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String str);

    public abstract DocumentFile createFile(String str, String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    public abstract String getName();

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String str);

    DocumentFile(DocumentFile parent) {
        this.mParent = parent;
    }

    public static DocumentFile fromFile(File file) {
        return new RawDocumentFile(null, file);
    }

    public static DocumentFile fromSingleUri(Context context, Uri singleUri) {
        int i = Build.VERSION.SDK_INT;
        return new SingleDocumentFile(null, context, singleUri);
    }

    public static DocumentFile fromTreeUri(Context context, Uri treeUri) {
        int i = Build.VERSION.SDK_INT;
        return new TreeDocumentFile(null, context, DocumentsContractApi21.prepareTreeUri(treeUri));
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        int i = Build.VERSION.SDK_INT;
        return DocumentsContractApi19.isDocumentUri(context, uri);
    }

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public DocumentFile findFile(String displayName) {
        DocumentFile[] arr$ = listFiles();
        for (DocumentFile doc : arr$) {
            if (displayName.equals(doc.getName())) {
                return doc;
            }
        }
        return null;
    }
}
