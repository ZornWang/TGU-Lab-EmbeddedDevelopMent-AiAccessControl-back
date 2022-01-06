package com.example.embeddedback.mapper;

import com.example.embeddedback.dto.face.SearchFaceDto;
import com.example.embeddedback.pojo.Face;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface FaceMapper {
    @Select("select exists(select 1 from face where face_token = #{faceToken})")
    boolean faceTokenExists(String faceToken);

    @Insert("insert into face (guest_id,face_token) values(#{guestId},#{faceToken})")
    void insertFace(int guestId, String faceToken);

//    @Select("select * from face where guest_id = #{guestId}")
//    Face[] getGuestAllFacesByGuestId(int guestId);
//
//    @Select("select * from face where id = #{id}")
//    Face[] getGuestAllFacesById(int id);

    Face[] getGuestFace(SearchFaceDto searchFaceDto);

    @Select("select * from face where face_token = #{faceToken}")
    Face getFaceByToken(String faceToken);

    @Select("select * from face where id = #{id}")
    Face getFaceById(int id);

    @Delete("delete from face where id = #{id}")
    void deleteFace(int id);
}
