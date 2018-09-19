package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public class UserMapperTest extends BaseMapperTest {
    //获取SqlSession
    private final SqlSession sqlSession = getSqlSession();
    @Test
    public void testSelectById() {
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertNotNull(user);
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }

    }

    @Test
    public void testSelectAll() {
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = mapper.selectAll();
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size() > 0);
        } finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }

    }

    @Test
    public void testSelectRoleByUserId() {
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = mapper.selectRoleByUserId(1L);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

}
