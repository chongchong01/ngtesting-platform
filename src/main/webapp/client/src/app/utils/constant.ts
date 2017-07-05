export var CONSTANT:any = {
  _SERVICE_URL_DEV: 'http://localhost:8080/platform/',
  _SERVICE_URL_PRODUCTION: 'http://172.16.90.66:8080/platform/',

  SERVICE_URL: undefined,
  API_URL: undefined,

  API_PATH: 'api/client/v1/',
  UPLOAD_URI: 'uploadSingle',

  TOKEN: undefined,
  ORG_ID: undefined,
  PROJECT_ID: 2,

  PROFILE: undefined,
  RECENT_PROJECT: undefined,
  CUSTOM_FIELD_FOR_PROJECT: undefined,

  TOKEN_KEY: 'com.ngtesting.token',
  TOKEN_EXPIRE: 'com.ngtesting.expire',

  ExeStatus: {'not_start': '未开始', 'in_progress': '执行中', 'end': '已结束'},
  EntityDisabled: {'false': '启用', 'true': '归档', '': '所有'},

  ScreenSize: {h: 0, w: 0},
  DebounceTime: 800
};

