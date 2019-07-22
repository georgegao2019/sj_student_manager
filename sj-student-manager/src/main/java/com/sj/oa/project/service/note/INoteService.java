package com.sj.oa.project.service.note;

import com.sj.oa.project.po.Note;

import java.util.List;

/**
 * @author 永健
 */
public interface INoteService{
    int deleteByPrimaryKeys(Integer[] id);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Note record);

    List<Note> selectNoteList(Note note);
}
