package com.xu.scw.vo;

import org.activiti.engine.ProcessEngineConfiguration;


import java.util.*;

/**
 * @authorxuhongda on 2017/12/17
 * com.xu.scw.vo
 * scw-parent
 */
public class ProcessDefinitionEntityVO {
    protected String key;
    protected int revision = 1;
    protected int version;
    protected String id;
    protected String name;
    protected String category;
    protected String deploymentId;
    protected String description;
    protected String resourceName;
    protected String tenantId = ProcessEngineConfiguration.NO_TENANT_ID;
    protected Integer historyLevel;
    protected String diagramResourceName;
    protected boolean isGraphicalNotationDefined;
    protected boolean graphicalNotation;
    protected boolean hasStartFormKey;
    protected boolean suspended;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getHistoryLevel() {
        return historyLevel;
    }

    public void setHistoryLevel(Integer historyLevel) {
        this.historyLevel = historyLevel;
    }

    public String getDiagramResourceName() {
        return diagramResourceName;
    }

    public void setDiagramResourceName(String diagramResourceName) {
        this.diagramResourceName = diagramResourceName;
    }

    public boolean isGraphicalNotationDefined() {
        return isGraphicalNotationDefined;
    }

    public void setGraphicalNotationDefined(boolean graphicalNotationDefined) {
        isGraphicalNotationDefined = graphicalNotationDefined;
    }

    public boolean isGraphicalNotation() {
        return graphicalNotation;
    }

    public void setGraphicalNotation(boolean graphicalNotation) {
        this.graphicalNotation = graphicalNotation;
    }

    public boolean isHasStartFormKey() {
        return hasStartFormKey;
    }

    public void setHasStartFormKey(boolean hasStartFormKey) {
        this.hasStartFormKey = hasStartFormKey;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }
}
