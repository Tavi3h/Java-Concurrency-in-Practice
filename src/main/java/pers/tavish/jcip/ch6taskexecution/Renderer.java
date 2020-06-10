package pers.tavish.jcip.ch6taskexecution;

import java.util.List;
import java.util.concurrent.*;

// 程序清单6-15
public abstract class Renderer {

    private final ExecutorService executor;

    Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source) {

        List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(executor);

        for (ImageInfo imageInfo : info) {
            completionService.submit(imageInfo::downloadImage);
        }

        renderText(source);

        try {
            for (int t = 0, n = info.size(); t < n; t++) {
                Future<ImageData> f = completionService.take();
                ImageData imageData = f.get();
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw LaunderThrowable.launderThrowable(e.getCause());
        }
    }

    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);

    static class LaunderThrowable {

        static RuntimeException launderThrowable(Throwable t) {
            if (t instanceof RuntimeException)
                return (RuntimeException) t;
            else if (t instanceof Error)
                throw (Error) t;
            else
                throw new IllegalStateException("Not unchecked", t);
        }
    }
}
