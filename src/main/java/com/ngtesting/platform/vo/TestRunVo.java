package com.ngtesting.platform.vo;

import java.util.*;

public class TestRunVo extends BaseVo {

    private static final long serialVersionUID = 3655131645148750323L;
    private String name;
    private Integer estimate;

    private String status;

    protected Date startTime;

    protected Date endTime;

    private String descr;

    private Integer ordr;

    private Long projectId;

    private Long planId;

    private Long userId;
    private String userName;

    public TestRunVo() {

    }
    public TestRunVo(Long id, String name, Integer estimate, String status,
        String descr, Integer ordr, Long projectId, Long planId, Long userId, String userName) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.status = status;
        this.descr = descr;
        this.ordr = ordr;
        this.projectId = projectId;
        this.planId = planId;
        this.userId = userId;
        this.userName = userName;
    }

    private List<UserVo> assignees = new LinkedList<>();

    private Map<String, Integer> countMap = new HashMap<String, Integer>(){{
        put("total", 0);
        put("pass", 0);
        put("fail", 0);
        put("block", 0);
        put("untest", 0);
    }};
    private Map<String, Integer> widthMap = new HashMap<String, Integer>(){{
        put("total", 0);
        put("pass", 0);
        put("fail", 0);
        put("block", 0);
        put("untest", 0);
    }};

    public List<UserVo> getAssignees() {
        return assignees;
    }
    public void setAssignees(List<UserVo> assignees) {
        this.assignees = assignees;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, Integer> getWidthMap() {
        return widthMap;
    }

    public void setWidthMap(Map<String, Integer> widthMap) {
        this.widthMap = widthMap;
    }

    public Map<String, Integer> getCountMap() {
        return countMap;
    }

    public void setCountMap(Map<String, Integer> countMap) {
        this.countMap = countMap;
    }

    public Integer getOrdr() {
        return ordr;
    }

    public void setOrdr(Integer ordr) {
        this.ordr = ordr;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

}
