package com.iqoption.dto.entity.video;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoEducation {
    public Double duration;
    public String name;
    public Integer namePosition;
    public Integer position;
    public String preview;
    public Integer progress = null;
    public Long size;
    public String url;
    public Boolean viewed = Boolean.valueOf(false);

    public static class List extends ArrayList<VideoEducation> {
        @Nullable
        public VideoEducation getItem(int i) {
            Iterator it = iterator();
            while (it.hasNext()) {
                VideoEducation videoEducation = (VideoEducation) it.next();
                if (videoEducation.hashCode() == i) {
                    return videoEducation;
                }
            }
            return null;
        }

        public void merge(List list) {
            if (list != null) {
                Iterator it = iterator();
                while (it.hasNext()) {
                    VideoEducation videoEducation = (VideoEducation) it.next();
                    videoEducation.merge(list.getItem(videoEducation.hashCode()));
                }
            }
        }
    }

    private void merge(VideoEducation videoEducation) {
        this.progress = videoEducation.progress;
        this.viewed = videoEducation.viewed;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VideoEducation videoEducation = (VideoEducation) obj;
        if (!this.url == null ? this.url.equals(videoEducation.url) : videoEducation.url == null) {
            return false;
        }
        if (!this.preview == null ? this.preview.equals(videoEducation.preview) : videoEducation.preview == null) {
            return false;
        }
        if (!this.size == null ? this.size.equals(videoEducation.size) : videoEducation.size == null) {
            return false;
        }
        if (this.duration != null) {
            z = this.duration.equals(videoEducation.duration);
        } else if (videoEducation.duration != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((this.url != null ? this.url.hashCode() : 0) * 31) + (this.preview != null ? this.preview.hashCode() : 0)) * 31) + (this.size != null ? this.size.hashCode() : 0)) * 31;
        if (this.duration != null) {
            i = this.duration.hashCode();
        }
        return hashCode + i;
    }
}
