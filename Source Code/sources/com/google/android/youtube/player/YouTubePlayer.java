package com.google.android.youtube.player;

public interface YouTubePlayer {

    public enum ErrorReason {
        EMBEDDING_DISABLED,
        BLOCKED_FOR_APP,
        NOT_PLAYABLE,
        NETWORK_ERROR,
        UNAUTHORIZED_OVERLAY,
        PLAYER_VIEW_TOO_SMALL,
        PLAYER_VIEW_NOT_VISIBLE,
        EMPTY_PLAYLIST,
        AUTOPLAY_DISABLED,
        USER_DECLINED_RESTRICTED_CONTENT,
        USER_DECLINED_HIGH_BANDWIDTH,
        UNEXPECTED_SERVICE_DISCONNECTION,
        INTERNAL_ERROR,
        UNKNOWN
    }

    public interface a {
        void Z(boolean z);
    }

    public interface b {
        void a(e eVar, YouTubeInitializationResult youTubeInitializationResult);

        void a(e eVar, YouTubePlayer youTubePlayer, boolean z);
    }

    public interface c {
        void aa(boolean z);

        void av(int i);

        void oZ();

        void onPaused();

        void onStopped();
    }

    public interface d {
        void a(ErrorReason errorReason);

        void cz(String str);

        void pa();

        void pb();

        void pc();

        void pd();
    }

    public interface e {
    }

    void a(a aVar);

    void a(c cVar);

    void a(d dVar);

    void au(int i);

    void cy(String str);

    boolean isPlaying();

    int oX();

    int oY();

    void pause();

    void play();

    void setFullscreen(boolean z);
}
