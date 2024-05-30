package com.emilasheras.components.models;

public interface CModelInterface {
    Long getId();
    void setId(Long id);

    void save();
    void update();
    void delete();
}