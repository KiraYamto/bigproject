package org.bobo.model.es;

import org.bobo.util.elasticsearch.ESOperateType;

import java.io.Serializable;

/**
 * @Author: bobo
 * @Date: 2020/11/27 14:31
 */

//ES mete 元数据
public class EsBaseDoc implements Serializable {

    private String _index;
    private String _type;
    private String _id;
    private int _version;
    private float _score;
    private String _source;
    private String _timestamp;

    private ESOperateType operateType;


    public ESOperateType getOperateType() {
        return operateType;
    }

    public void setOperateType(ESOperateType operateType) {
        this.operateType = operateType;
    }

    public String get_timestamp() {
        return _timestamp;
    }

    public void set_timestamp(String _timestamp) {
        this._timestamp = _timestamp;
    }

    public String get_index() {
        return _index;
    }

    public void set_index(String _index) {
        this._index = _index;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int get_version() {
        return _version;
    }

    public void set_version(int _version) {
        this._version = _version;
    }

    public float get_score() {
        return _score;
    }

    public void set_score(float _score) {
        this._score = _score;
    }

    public String get_source() {
        return _source;
    }

    public void set_source(String _source) {
        this._source = _source;
    }
}
