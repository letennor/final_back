package com.final_back;

import com.final_back.mapper.RolePriMapper;
import com.final_back.mapper.UserBasicInfoMapper;
import com.final_back.mapper.UserPasswordInfoMapper;
import com.final_back.entity.RolePri;
import com.final_back.entity.UserBasicInfo;
import com.final_back.entity.UserPasswordInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootTest
class FinalBackApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    private RolePriMapper rolePriMapper;
    @Autowired
    private UserBasicInfoMapper userBasicInfoMapper;
    @Autowired
    private UserPasswordInfoMapper userPasswordInfoMapper;

    @Test
    void contextLoads() {
        System.out.println("测试用例");
    }

    @Test
    void Test() throws SQLException {

        //看一下数据源
        System.out.println("数据源：" + dataSource.getClass());
        //获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭连接
        connection.close();
    }

    @Test
    void TestMBP(){
        List<RolePri> rolePriList = rolePriMapper.selectList(null);
        for (int i = 0; i < rolePriList.size(); i++) {
            System.out.println(rolePriList.get(i));
        }
    }

    @Test
    void insertTest(){
        RolePri rolePri = new RolePri();
        rolePri.setRolePriId(3L);
        rolePri.setRoleId(4L);
        rolePri.setPrivilege_id(5L);
        rolePri.setGmtCreate(new Date());
        rolePri.setGmtModified(new Date());
        int insert = rolePriMapper.insert(rolePri);
        System.out.println("insert:" + insert);
    }
    @Test
    void insertTest2(){
        RolePri rolePri = new RolePri();
//        rolePri.setRolePriId(3L);
        rolePri.setRoleId(4L);
        rolePri.setPrivilege_id(5L);
        rolePri.setGmtCreate(new Date());
        rolePri.setGmtModified(new Date());
        int insert = rolePriMapper.insert(rolePri);
        System.out.println("insert:" + insert);
    }

    @Test
    void updateTest(){
        RolePri rolePri = new RolePri();
        rolePri.setRolePriId(1593497488105951233L);
        rolePri.setPrivilege_id(999L);
        int i = rolePriMapper.updateById(rolePri);
        System.out.println("update:" + i);
    }

    @Test
    void insertAutoTest(){
        RolePri rolePri = new RolePri();
        rolePri.setRoleId(123L);
        rolePri.setPrivilege_id(123L);
        int insert = rolePriMapper.insert(rolePri);
        System.out.println("insert:" + insert);
    }

    @Test
    void insertUserBasicInfo(){
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        userBasicInfo.setGender(1);
        userBasicInfo.setName("王五");
        userBasicInfo.setAge(32);
        userBasicInfo.setWorkYear(4);
        userBasicInfo.setEntryTime(new Date());
        userBasicInfo.setSalary(4000.0);
        userBasicInfo.setPhoneNumber("123189102013");
        userBasicInfo.setEmail("h1231231@123.com");
        userBasicInfo.setWechat("lala@112");
        userBasicInfo.setPhoto("user/picture/img");
        int insert = userBasicInfoMapper.insert(userBasicInfo);
        System.out.println(insert);


    }

    @Test
    void insertUserPasswordInfo(){
        UserPasswordInfo userPasswordInfo = new UserPasswordInfo();
        userPasswordInfo.setUserBasicInfoId(1594580274451607554L);
        userPasswordInfo.setState(1);
        userPasswordInfo.setUserName("wangwu");
        userPasswordInfo.setPassword("hfuiasudhufisahoah");
        userPasswordInfo.setOrganizationId(1L);
        int insert = userPasswordInfoMapper.insert(userPasswordInfo);
        System.out.println(insert);
    }

    @Test
    void testXMLSql(){
        UserBasicInfo userPassword = userBasicInfoMapper.getUserPassword(1594578912879919105L);
        System.out.println(userPassword);

    }


}
