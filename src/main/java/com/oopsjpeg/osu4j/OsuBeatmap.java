package com.oopsjpeg.osu4j;

import com.google.gson.JsonObject;
import com.oopsjpeg.osu4j.abstractbackend.Lazy;
import com.oopsjpeg.osu4j.backend.EndpointBeatmapSet;
import com.oopsjpeg.osu4j.backend.EndpointUsers;
import com.oopsjpeg.osu4j.backend.Osu;
import com.oopsjpeg.osu4j.util.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.ZonedDateTime;

public class OsuBeatmap extends OsuElement {
	private ApprovalState approved;
	private ZonedDateTime approvedDate;
	private ZonedDateTime lastUpdate;
	private String artist;
	private int beatmapID = -1;
	private int beatmapSetID;
	private Lazy<OsuBeatmapSet> beatmapSet;
	private float bpm;
	private String creatorName = null;
	private Lazy<OsuUser> creator;
	private float difficultyrating;
	private float diffSize;
	private float diffOverall;
	private float diffApproach;
	private float diffDrain;
	private int hitLength;
	private String source;
	private Genre genre;
	private Language language;
	private String title;
	private int totalLength;
	private String version;
	private String fileMD5;
	private GameMode mode;
	private String[] tags;
	private int favouriteCount;
	private int playcount;
	private int passcount;
	private int maxCombo;

	public OsuBeatmap(Osu api, JsonObject obj) {
		super(api);
		if (obj.has("approved")) approved = ApprovalState.fromID(obj.get("approved").getAsInt());
		if (obj.has("approved_date")) approvedDate = obj.get("approved_date").isJsonNull() ? null : Utility.parseDate(obj.get("approved_date").getAsString());
		if (obj.has("last_update")) lastUpdate = Utility.parseDate(obj.get("last_update").getAsString());
	    if (obj.has("artist")) artist = obj.get("artist").getAsString();
	    if (obj.has("beatmap_id")) beatmapID = obj.get("beatmap_id").getAsInt();
	    if (obj.has("beatmapset_id")) beatmapSetID = obj.get("beatmapset_id").getAsInt();
	    if (obj.has("bpm")) bpm = obj.get("bpm").getAsFloat();
	    if (obj.has("creator")) creatorName = obj.get("creator").getAsString();
	    if (obj.has("difficultyrating")) difficultyrating = obj.get("difficultyrating").getAsFloat();
	    if (obj.has("diff_size")) diffSize = obj.get("diff_size").getAsFloat();
	    if (obj.has("diff_overall")) diffOverall = obj.get("diff_overall").getAsFloat();
	    if (obj.has("diff_approach")) diffApproach = obj.get("diff_approach").getAsFloat();
	    if (obj.has("diff_drain")) diffDrain = obj.get("diff_drain").getAsFloat();
	    if (obj.has("hit_length")) hitLength = obj.get("hit_length").getAsInt();
	    if (obj.has("source")) source = obj.get("source").getAsString();
	    if (obj.has("genre_id")) genre = Genre.fromID(obj.get("genre_id").getAsInt());
	    if (obj.has("language_id")) language = Language.fromID(obj.get("language_id").getAsInt());
	    if (obj.has("title")) title = obj.get("title").getAsString();
	    if (obj.has("total_length")) totalLength = obj.get("total_length").getAsInt();
	    if (obj.has("version")) version = obj.get("version").getAsString();
	    if (obj.has("file_md5")) fileMD5 = obj.get("file_md5").getAsString();
	    if (obj.has("mode")) mode = GameMode.fromID(obj.get("mode").getAsInt());
	    if (obj.has("tags")) tags = obj.get("tags").getAsString().split(" ");
	    if (obj.has("favourite_count")) favouriteCount = obj.get("favourite_count").getAsInt();
	    if (obj.has("playcount")) playcount = obj.get("playcount").getAsInt();
	    if (obj.has("passcount")) passcount = obj.get("passcount").getAsInt();
	    if (obj.has("max_combo")) maxCombo = obj.get("max_combo").getAsInt();

		if (beatmapID != -1) beatmapSet = getAPI().beatmapSets.getAsQuery(new EndpointBeatmapSet.Arguments(beatmapSetID))
				.asLazilyLoaded();
		if (creatorName != null) creator = getAPI().users.getAsQuery(new EndpointUsers.ArgumentsBuilder(creatorName).build())
				.asLazilyLoaded();
	}

	public OsuBeatmap(OsuBeatmap other) {
		super(other);
		this.approved = other.approved;
		this.approvedDate = other.approvedDate;
		this.lastUpdate = other.lastUpdate;
		this.artist = other.artist;
		this.beatmapID = other.beatmapID;
		this.beatmapSetID = other.beatmapSetID;
		this.beatmapSet = other.beatmapSet;
		this.bpm = other.bpm;
		this.creatorName = other.creatorName;
		this.creator = other.creator;
		this.difficultyrating = other.difficultyrating;
		this.diffSize = other.diffSize;
		this.diffOverall = other.diffOverall;
		this.diffApproach = other.diffApproach;
		this.diffDrain = other.diffDrain;
		this.hitLength = other.hitLength;
		this.source = other.source;
		this.genre = other.genre;
		this.language = other.language;
		this.title = other.title;
		this.totalLength = other.totalLength;
		this.version = other.version;
		this.fileMD5 = other.fileMD5;
		this.mode = other.mode;
		this.tags = other.tags;
		this.favouriteCount = other.favouriteCount;
		this.playcount = other.playcount;
		this.passcount = other.passcount;
		this.maxCombo = other.maxCombo;
	}

	public ApprovalState getApproved() {
		return approved;
	}

	public ZonedDateTime getApprovedDate() {
		return approvedDate;
	}

	public ZonedDateTime getLastUpdate() {
		return lastUpdate;
	}

	public String getArtist() {
		return artist;
	}

	public int getID() {
		return beatmapID;
	}

	public int getBeatmapSetID() {
		return beatmapSetID;
	}

	public Lazy<OsuBeatmapSet> getBeatmapSet() {
		return beatmapSet;
	}

	public float getBPM() {
		return bpm;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public Lazy<OsuUser> getCreator() {
		return creator;
	}

	public float getDifficulty() {
		return difficultyrating;
	}

	public float getSize() {
		return diffSize;
	}

	public float getOverall() {
		return diffOverall;
	}

	public float getApproach() {
		return diffApproach;
	}

	public float getDrain() {
		return diffDrain;
	}

	public int getHitLength() {
		return hitLength;
	}

	public String getSource() {
		return source;
	}

	public Genre getGenre() {
		return genre;
	}

	public Language getLanguage() {
		return language;
	}

	public String getTitle() {
		return title;
	}

	public int getTotalLength() {
		return totalLength;
	}

	public String getVersion() {
		return version;
	}

	public String getFileMD5() {
		return fileMD5;
	}

	public GameMode getMode() {
		return mode;
	}

	public String[] getTags() {
		return tags;
	}

	public int getFavouriteCount() {
		return favouriteCount;
	}

	public int getFavoriteCount() {
		return favouriteCount;
	}

	public int getPlayCount() {
		return playcount;
	}

	public int getPassCount() {
		return passcount;
	}

	public int getMaxCombo() {
		return maxCombo;
	}

	public URL getURL() throws MalformedURLException {
		return new URL(Osu.BASE_URL + "/b/" + beatmapID);
	}

	@Override
	public String toString() {
		return artist + " - " + title + " [" + version + "]";
	}
}
