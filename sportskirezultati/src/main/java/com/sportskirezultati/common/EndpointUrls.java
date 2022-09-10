package com.sportskirezultati.common;

/**
 * Url Constants.
 */
public class EndpointUrls {

  private EndpointUrls() {

  }

  public static final String AUTH_URL = "/api/auth";
  public static final String AUTH_LOGIN_URL = "/signin";
  public static final String AUTH_REGISTER_URL = "/signup";
  public static final String AUTH_REFRESH_TOKEN_URL = "/refreshToken";
  public static final String AUTH_LOGOUT_URL = "/logout";

  public static final String SPORT_API = "/api/sport";

  public static final String FOOTBALL_EVENTS_API = SPORT_API + "/football";
  public static final String FOOTBALL_DATA = "/data";
  public static final String SET_BET = "/setBet";

  public static final String PROFILE_API = "api/profile";
  public static final String PROFILE = "/profile";

  public static final String SEARCH_API = "/api/search";

  public static final String FRIENDS_API = "/api/friends";
  public static final String ADD_FRIEND = "/add";
  public static final String REMOVE_REQUEST = "/removeRequest";
  public static final String ACCEPT_REQUEST = "/accept";
  public static final String DECLINE_REQUEST = "/decline";
  public static final String REMOVE_FRIEND = "/removeFriend";
  public static final String FRIENDS_LIST = "/friendsList";

  public static final String ADMIN_API = "api/admin";
  public static final String DISABLE_USER = "/disableUser";
  public static final String GIVE_MOD = "/giveMod";
  public static final String REMOVE_MOD = "/removeMod";

  public static final String MOD_API = "api/mod";
  public static final String BAN_USER = "/ban";
  public static final String CHANGE_POINTS = "/changePoints";
}
