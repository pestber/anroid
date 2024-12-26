package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class PrintHelperKitkat {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    private static final String LOG_TAG = "PrintHelperKitkat";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions = null;
    private final Object mLock = new Object();
    int mScaleMode = 2;
    int mColorMode = 2;
    int mOrientation = 1;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    PrintHelperKitkat(Context context) {
        this.mContext = context;
    }

    public void setScaleMode(int scaleMode) {
        this.mScaleMode = scaleMode;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    public void setColorMode(int colorMode) {
        this.mColorMode = colorMode;
    }

    public void setOrientation(int orientation) {
        this.mOrientation = orientation;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public void printBitmap(final String jobName, final Bitmap bitmap, final OnPrintFinishCallback callback) {
        PrintAttributes.MediaSize mediaSize;
        if (bitmap == null) {
            return;
        }
        final int fittingMode = this.mScaleMode;
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.MediaSize mediaSize2 = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
        if (bitmap.getWidth() <= bitmap.getHeight()) {
            mediaSize = mediaSize2;
        } else {
            PrintAttributes.MediaSize mediaSize3 = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            mediaSize = mediaSize3;
        }
        PrintAttributes attr = new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.mColorMode).build();
        printManager.print(jobName, new PrintDocumentAdapter() { // from class: android.support.v4.print.PrintHelperKitkat.1
            private PrintAttributes mAttributes;

            @Override // android.print.PrintDocumentAdapter
            public void onLayout(PrintAttributes oldPrintAttributes, PrintAttributes newPrintAttributes, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                this.mAttributes = newPrintAttributes;
                PrintDocumentInfo info = new PrintDocumentInfo.Builder(jobName).setContentType(1).setPageCount(1).build();
                boolean changed = true ^ newPrintAttributes.equals(oldPrintAttributes);
                layoutResultCallback.onLayoutFinished(info, changed);
            }

            @Override // android.print.PrintDocumentAdapter
            public void onWrite(PageRange[] pageRanges, ParcelFileDescriptor fileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                PrintedPdfDocument pdfDocument = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.mAttributes);
                try {
                    PdfDocument.Page page = pdfDocument.startPage(1);
                    RectF content = new RectF(page.getInfo().getContentRect());
                    Matrix matrix = PrintHelperKitkat.this.getMatrix(bitmap.getWidth(), bitmap.getHeight(), content, fittingMode);
                    page.getCanvas().drawBitmap(bitmap, matrix, null);
                    pdfDocument.finishPage(page);
                    try {
                        pdfDocument.writeTo(new FileOutputStream(fileDescriptor.getFileDescriptor()));
                        writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                    } catch (IOException ioe) {
                        Log.e(PrintHelperKitkat.LOG_TAG, "Error writing printed content", ioe);
                        writeResultCallback.onWriteFailed(null);
                    }
                    pdfDocument.close();
                    if (fileDescriptor != null) {
                        try {
                            fileDescriptor.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th) {
                    pdfDocument.close();
                    if (fileDescriptor != null) {
                        try {
                            fileDescriptor.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            }

            @Override // android.print.PrintDocumentAdapter
            public void onFinish() {
                if (callback != null) {
                    callback.onFinish();
                }
            }
        }, attr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Matrix getMatrix(int imageWidth, int imageHeight, RectF content, int fittingMode) {
        float scale;
        Matrix matrix = new Matrix();
        float scale2 = content.width() / imageWidth;
        if (fittingMode == 2) {
            scale = Math.max(scale2, content.height() / imageHeight);
        } else {
            scale = Math.min(scale2, content.height() / imageHeight);
        }
        matrix.postScale(scale, scale);
        float translateX = (content.width() - (imageWidth * scale)) / 2.0f;
        float translateY = (content.height() - (imageHeight * scale)) / 2.0f;
        matrix.postTranslate(translateX, translateY);
        return matrix;
    }

    public void printBitmap(String jobName, Uri imageFile, OnPrintFinishCallback callback) throws FileNotFoundException {
        int fittingMode = this.mScaleMode;
        PrintDocumentAdapter printDocumentAdapter = new AnonymousClass2(jobName, imageFile, callback, fittingMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.mColorMode);
        if (this.mOrientation == 1) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.mOrientation == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        PrintAttributes attr = builder.build();
        printManager.print(jobName, printDocumentAdapter, attr);
    }

    /* renamed from: android.support.v4.print.PrintHelperKitkat$2, reason: invalid class name */
    class AnonymousClass2 extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        Bitmap mBitmap = null;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
        final /* synthetic */ OnPrintFinishCallback val$callback;
        final /* synthetic */ int val$fittingMode;
        final /* synthetic */ Uri val$imageFile;
        final /* synthetic */ String val$jobName;

        AnonymousClass2(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
            this.val$jobName = str;
            this.val$imageFile = uri;
            this.val$callback = onPrintFinishCallback;
            this.val$fittingMode = i;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.support.v4.print.PrintHelperKitkat$2$1] */
        @Override // android.print.PrintDocumentAdapter
        public void onLayout(final PrintAttributes oldPrintAttributes, final PrintAttributes newPrintAttributes, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.mAttributes = newPrintAttributes;
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else {
                if (this.mBitmap != null) {
                    PrintDocumentInfo info = new PrintDocumentInfo.Builder(this.val$jobName).setContentType(1).setPageCount(1).build();
                    boolean changed = true ^ newPrintAttributes.equals(oldPrintAttributes);
                    layoutResultCallback.onLayoutFinished(info, changed);
                    return;
                }
                this.mLoadBitmap = new AsyncTask<Uri, Boolean, Bitmap>() { // from class: android.support.v4.print.PrintHelperKitkat.2.1
                    @Override // android.os.AsyncTask
                    protected void onPreExecute() {
                        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: android.support.v4.print.PrintHelperKitkat.2.1.1
                            @Override // android.os.CancellationSignal.OnCancelListener
                            public void onCancel() {
                                AnonymousClass2.this.cancelLoad();
                                cancel(false);
                            }
                        });
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public Bitmap doInBackground(Uri... uris) {
                        try {
                            return PrintHelperKitkat.this.loadConstrainedBitmap(AnonymousClass2.this.val$imageFile, PrintHelperKitkat.MAX_PRINT_SIZE);
                        } catch (FileNotFoundException e) {
                            return null;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(Bitmap bitmap) {
                        super.onPostExecute((AnonymousClass1) bitmap);
                        AnonymousClass2.this.mBitmap = bitmap;
                        if (bitmap == null) {
                            layoutResultCallback.onLayoutFailed(null);
                        } else {
                            PrintDocumentInfo info2 = new PrintDocumentInfo.Builder(AnonymousClass2.this.val$jobName).setContentType(1).setPageCount(1).build();
                            boolean changed2 = true ^ newPrintAttributes.equals(oldPrintAttributes);
                            layoutResultCallback.onLayoutFinished(info2, changed2);
                        }
                        AnonymousClass2.this.mLoadBitmap = null;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onCancelled(Bitmap result) {
                        layoutResultCallback.onLayoutCancelled();
                        AnonymousClass2.this.mLoadBitmap = null;
                    }
                }.execute(new Uri[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancelLoad() {
            synchronized (PrintHelperKitkat.this.mLock) {
                if (PrintHelperKitkat.this.mDecodeOptions != null) {
                    PrintHelperKitkat.this.mDecodeOptions.requestCancelDecode();
                    PrintHelperKitkat.this.mDecodeOptions = null;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            cancelLoad();
            if (this.mLoadBitmap != null) {
                this.mLoadBitmap.cancel(true);
            }
            if (this.val$callback != null) {
                this.val$callback.onFinish();
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRanges, ParcelFileDescriptor fileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintedPdfDocument pdfDocument = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.mAttributes);
            try {
                PdfDocument.Page page = pdfDocument.startPage(1);
                RectF content = new RectF(page.getInfo().getContentRect());
                Matrix matrix = PrintHelperKitkat.this.getMatrix(this.mBitmap.getWidth(), this.mBitmap.getHeight(), content, this.val$fittingMode);
                page.getCanvas().drawBitmap(this.mBitmap, matrix, null);
                pdfDocument.finishPage(page);
                try {
                    pdfDocument.writeTo(new FileOutputStream(fileDescriptor.getFileDescriptor()));
                    writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } catch (IOException ioe) {
                    Log.e(PrintHelperKitkat.LOG_TAG, "Error writing printed content", ioe);
                    writeResultCallback.onWriteFailed(null);
                }
                pdfDocument.close();
                if (fileDescriptor != null) {
                    try {
                        fileDescriptor.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable th) {
                pdfDocument.close();
                if (fileDescriptor != null) {
                    try {
                        fileDescriptor.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap loadConstrainedBitmap(Uri uri, int maxSideLength) throws FileNotFoundException {
        BitmapFactory.Options decodeOptions;
        if (maxSideLength <= 0 || uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inJustDecodeBounds = true;
        loadBitmap(uri, opt);
        int w = opt.outWidth;
        int h = opt.outHeight;
        if (w <= 0 || h <= 0) {
            return null;
        }
        int imageSide = Math.max(w, h);
        int sampleSize = 1;
        while (imageSide > maxSideLength) {
            imageSide >>>= 1;
            sampleSize <<= 1;
        }
        if (sampleSize <= 0 || Math.min(w, h) / sampleSize <= 0) {
            return null;
        }
        synchronized (this.mLock) {
            this.mDecodeOptions = new BitmapFactory.Options();
            this.mDecodeOptions.inMutable = true;
            this.mDecodeOptions.inSampleSize = sampleSize;
            decodeOptions = this.mDecodeOptions;
        }
        try {
            Bitmap loadBitmap = loadBitmap(uri, decodeOptions);
            synchronized (this.mLock) {
                this.mDecodeOptions = null;
            }
            return loadBitmap;
        } catch (Throwable th) {
            synchronized (this.mLock) {
                this.mDecodeOptions = null;
                throw th;
            }
        }
    }

    private Bitmap loadBitmap(Uri uri, BitmapFactory.Options o) throws FileNotFoundException {
        if (uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream is = null;
        try {
            is = this.mContext.getContentResolver().openInputStream(uri);
            return BitmapFactory.decodeStream(is, null, o);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException t) {
                    Log.w(LOG_TAG, "close fail ", t);
                }
            }
        }
    }
}
