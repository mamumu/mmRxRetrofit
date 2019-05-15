package com.mumu.mmrxretrofit;

import java.io.Serializable;
import java.util.List;

public class LoginEntity implements Serializable {

    /**
     * timestamp : 1557906709869
     * resthead : {"errorCode":0,"message":""}
     * restbody : {"id":277,"name":"13555555555","userType":null,"authLevel":"区级","authLevelId":null,"viewRole":null,"viewRoleName":"综治","roleIds":[82],"state":true,"regionIds":[341253],"regionNames":null,"roleNames":["网格员角色"],"createTime":"2019-02-26 12:04:39","regionName":"北沥村","peopleName":"阿三","phone":"13555555555","gridIds":[2093],"orgId":null,"orgName":null,"orgPosition":null,"postId":null,"postName":null,"feignGridDTOList":[{"gridId":2093,"gridName":"6号网格北沥公寓6","areaPath":"1,2077,2078,2083,341247,341253","staffId":0,"staffName":"","gridPath":"1,2,1788,2074,2087,2093","latitude":"28.720764","longitude":"115.988825","areaId":341253,"gridManage":13,"gridOperator":29,"gridLevel":"grid"}],"weChatAuth":3,"regionLongitude":null,"regionLatitude":null,"code":"360111490205","coverage":null}
     * extend : null
     */

    private long timestamp;
    private RestheadBean resthead;
    private RestbodyBean restbody;
    private Object extend;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public RestheadBean getResthead() {
        return resthead;
    }

    public void setResthead(RestheadBean resthead) {
        this.resthead = resthead;
    }

    public RestbodyBean getRestbody() {
        return restbody;
    }

    public void setRestbody(RestbodyBean restbody) {
        this.restbody = restbody;
    }

    public Object getExtend() {
        return extend;
    }

    public void setExtend(Object extend) {
        this.extend = extend;
    }

    public static class RestheadBean {
        /**
         * errorCode : 0
         * message :
         */

        private int errorCode;
        private String message;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class RestbodyBean {
        /**
         * id : 277
         * name : 13555555555
         * userType : null
         * authLevel : 区级
         * authLevelId : null
         * viewRole : null
         * viewRoleName : 综治
         * roleIds : [82]
         * state : true
         * regionIds : [341253]
         * regionNames : null
         * roleNames : ["网格员角色"]
         * createTime : 2019-02-26 12:04:39
         * regionName : 北沥村
         * peopleName : 阿三
         * phone : 13555555555
         * gridIds : [2093]
         * orgId : null
         * orgName : null
         * orgPosition : null
         * postId : null
         * postName : null
         * feignGridDTOList : [{"gridId":2093,"gridName":"6号网格北沥公寓6","areaPath":"1,2077,2078,2083,341247,341253","staffId":0,"staffName":"","gridPath":"1,2,1788,2074,2087,2093","latitude":"28.720764","longitude":"115.988825","areaId":341253,"gridManage":13,"gridOperator":29,"gridLevel":"grid"}]
         * weChatAuth : 3
         * regionLongitude : null
         * regionLatitude : null
         * code : 360111490205
         * coverage : null
         */

        private int id;
        private String name;
        private Object userType;
        private String authLevel;
        private Object authLevelId;
        private Object viewRole;
        private String viewRoleName;
        private boolean state;
        private Object regionNames;
        private String createTime;
        private String regionName;
        private String peopleName;
        private String phone;
        private Object orgId;
        private Object orgName;
        private Object orgPosition;
        private Object postId;
        private Object postName;
        private int weChatAuth;
        private Object regionLongitude;
        private Object regionLatitude;
        private String code;
        private Object coverage;
        private List<Integer> roleIds;
        private List<Integer> regionIds;
        private List<String> roleNames;
        private List<Integer> gridIds;
        private List<FeignGridDTOListBean> feignGridDTOList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getUserType() {
            return userType;
        }

        public void setUserType(Object userType) {
            this.userType = userType;
        }

        public String getAuthLevel() {
            return authLevel;
        }

        public void setAuthLevel(String authLevel) {
            this.authLevel = authLevel;
        }

        public Object getAuthLevelId() {
            return authLevelId;
        }

        public void setAuthLevelId(Object authLevelId) {
            this.authLevelId = authLevelId;
        }

        public Object getViewRole() {
            return viewRole;
        }

        public void setViewRole(Object viewRole) {
            this.viewRole = viewRole;
        }

        public String getViewRoleName() {
            return viewRoleName;
        }

        public void setViewRoleName(String viewRoleName) {
            this.viewRoleName = viewRoleName;
        }

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public Object getRegionNames() {
            return regionNames;
        }

        public void setRegionNames(Object regionNames) {
            this.regionNames = regionNames;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        public String getPeopleName() {
            return peopleName;
        }

        public void setPeopleName(String peopleName) {
            this.peopleName = peopleName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getOrgName() {
            return orgName;
        }

        public void setOrgName(Object orgName) {
            this.orgName = orgName;
        }

        public Object getOrgPosition() {
            return orgPosition;
        }

        public void setOrgPosition(Object orgPosition) {
            this.orgPosition = orgPosition;
        }

        public Object getPostId() {
            return postId;
        }

        public void setPostId(Object postId) {
            this.postId = postId;
        }

        public Object getPostName() {
            return postName;
        }

        public void setPostName(Object postName) {
            this.postName = postName;
        }

        public int getWeChatAuth() {
            return weChatAuth;
        }

        public void setWeChatAuth(int weChatAuth) {
            this.weChatAuth = weChatAuth;
        }

        public Object getRegionLongitude() {
            return regionLongitude;
        }

        public void setRegionLongitude(Object regionLongitude) {
            this.regionLongitude = regionLongitude;
        }

        public Object getRegionLatitude() {
            return regionLatitude;
        }

        public void setRegionLatitude(Object regionLatitude) {
            this.regionLatitude = regionLatitude;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getCoverage() {
            return coverage;
        }

        public void setCoverage(Object coverage) {
            this.coverage = coverage;
        }

        public List<Integer> getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(List<Integer> roleIds) {
            this.roleIds = roleIds;
        }

        public List<Integer> getRegionIds() {
            return regionIds;
        }

        public void setRegionIds(List<Integer> regionIds) {
            this.regionIds = regionIds;
        }

        public List<String> getRoleNames() {
            return roleNames;
        }

        public void setRoleNames(List<String> roleNames) {
            this.roleNames = roleNames;
        }

        public List<Integer> getGridIds() {
            return gridIds;
        }

        public void setGridIds(List<Integer> gridIds) {
            this.gridIds = gridIds;
        }

        public List<FeignGridDTOListBean> getFeignGridDTOList() {
            return feignGridDTOList;
        }

        public void setFeignGridDTOList(List<FeignGridDTOListBean> feignGridDTOList) {
            this.feignGridDTOList = feignGridDTOList;
        }

        public static class FeignGridDTOListBean {
            /**
             * gridId : 2093
             * gridName : 6号网格北沥公寓6
             * areaPath : 1,2077,2078,2083,341247,341253
             * staffId : 0
             * staffName :
             * gridPath : 1,2,1788,2074,2087,2093
             * latitude : 28.720764
             * longitude : 115.988825
             * areaId : 341253
             * gridManage : 13
             * gridOperator : 29
             * gridLevel : grid
             */

            private int gridId;
            private String gridName;
            private String areaPath;
            private int staffId;
            private String staffName;
            private String gridPath;
            private String latitude;
            private String longitude;
            private int areaId;
            private int gridManage;
            private int gridOperator;
            private String gridLevel;

            public int getGridId() {
                return gridId;
            }

            public void setGridId(int gridId) {
                this.gridId = gridId;
            }

            public String getGridName() {
                return gridName;
            }

            public void setGridName(String gridName) {
                this.gridName = gridName;
            }

            public String getAreaPath() {
                return areaPath;
            }

            public void setAreaPath(String areaPath) {
                this.areaPath = areaPath;
            }

            public int getStaffId() {
                return staffId;
            }

            public void setStaffId(int staffId) {
                this.staffId = staffId;
            }

            public String getStaffName() {
                return staffName;
            }

            public void setStaffName(String staffName) {
                this.staffName = staffName;
            }

            public String getGridPath() {
                return gridPath;
            }

            public void setGridPath(String gridPath) {
                this.gridPath = gridPath;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public int getAreaId() {
                return areaId;
            }

            public void setAreaId(int areaId) {
                this.areaId = areaId;
            }

            public int getGridManage() {
                return gridManage;
            }

            public void setGridManage(int gridManage) {
                this.gridManage = gridManage;
            }

            public int getGridOperator() {
                return gridOperator;
            }

            public void setGridOperator(int gridOperator) {
                this.gridOperator = gridOperator;
            }

            public String getGridLevel() {
                return gridLevel;
            }

            public void setGridLevel(String gridLevel) {
                this.gridLevel = gridLevel;
            }
        }
    }
}
