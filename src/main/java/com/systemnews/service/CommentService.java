package com.systemnews.service;

import com.systemnews.model.Comment;
import com.systemnews.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by RADEK on 2016-08-30.
 */
@Service
public class CommentService implements ServiceInteface<Comment>, CustomInterfaceComment{

    public CommentRepository commmentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commmentRepository = commentRepository;
    }


    @Override
    public List<Comment> getObj() {
        List<Comment> commentList = commmentRepository.findAll();
        return convertToDTOs(commentList);
    }

    private List<Comment> convertToDTOs(List<Comment> models) {

        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private Comment convertToDTO(Comment comment) {

        Comment dto = new Comment();
        dto.setId(comment.getId());
        dto.setData(comment.getData());
        dto.setAuthor(comment.getAuthor());
        dto.setNewsId(comment.getNewsId());

        return dto;
    }

    @Override
    public Comment create(Comment obj) {

        return commmentRepository.save(obj);
    }

    @Override
    public Comment findbyId(String id) {

        return null;
    }

    @Override
    public Comment update(Comment obj) {

        return null;
    }

    @Override
    public Comment findByNewsId(String id) {


        List<Comment> commentList = commmentRepository.findByNewsId(id);
        return (Comment) convertToDTOs(commentList);
    }
}
