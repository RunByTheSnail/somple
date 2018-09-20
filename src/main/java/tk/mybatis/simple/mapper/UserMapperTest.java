package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.Date;
import java.util.List;

public class UserMapperTest extends BaseMapperTest {
    //获取SqlSession
    private final SqlSession sqlSession = getSqlSession();
    @Test
    public void testSelectById() {
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectById方法,查询id=1的用户
            SysUser user = userMapper.selectById(1L);
            //user 不为空
            Assert.assertNotNull(user);
            //userName = admin
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
            //调用 selectAll 方法查询所有用户
            List<SysUser> userList = mapper.selectAll();
            //结采不为空
            Assert.assertNotNull(userList);
            //用户数量大于 0 个
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
            //调用 selectRolesByUserId 方法查询用户的角色
            List<SysRole> roleList = mapper.selectRoleByUserId(1L);
            //结果不为空
            Assert.assertNotNull(roleList);
            //角色数量大于0个
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert() {
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //创建一个user对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            //将新建的对象插入数据库中，特别注意这里的返回值 result 是执行的 SQL 影响的行数
            int result = mapper.inset(user);
            //只插入 l 条数据
            Assert.assertEquals(1, result);
            //id为null ，没有给id赋佳，并且没有配直回写id的值
            Assert.assertNotNull(user.getId());
        } finally {
            //为了不影响测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭sqlSession
            sqlSession.close();
        }

    }

    @Test
    public void testInsert2() {
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //创建一个user对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            //将新建的对象插入数据库中，特别注意这里的返回值 result 是执行的 SQL 影响的行数
            int result = mapper.inset2(user);
            //只插入 l 条数据
            Assert.assertEquals(1, result);
            //id为null ，没有给id赋佳，并且没有配直回写id的值
            Assert.assertNotNull(user.getId());
        } finally {
            //为了不影响测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭sqlSession
            sqlSession.close();
        }

    }

    @Test
    public void testInsert3() {
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //创建一个user对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            //将新建的对象插入数据库中，特别注意这里的返回值 result 是执行的 SQL 影响的行数
            int result = mapper.inset3(user);
            //只插入 l 条数据
            Assert.assertEquals(1, result);
            //id为null ，没有给id赋佳，并且没有配直回写id的值
            Assert.assertNotNull(user.getId());
        } finally {
            //为了不影响测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭sqlSession
            sqlSession.close();
        }

    }

    @Test
    public void testUpdateById() {
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //从数据库查询一个user对象
            SysUser user = mapper.selectById(1L);
            //当前userName为"admin"
            Assert.assertEquals("admin", user.getUserName());
            //修改用户名
            user.setUserName("admin_test");
            //修改邮箱
            user.setUserEmail("test@mybatis.tk");
            int result = mapper.updateById(user);
            //只更新1条数据
            Assert.assertEquals(1, result);
            user = mapper.selectById(1L);
            //修改后的名字是admin_test
            Assert.assertEquals("admin_test", user.getUserName());
        } finally {
            //为了不影响测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById() {
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //从数据库查询1个user对象，根据id=1查询
            SysUser user1 = userMapper.selectById(1L);
            //现在还能查询出user对象
            Assert.assertNotNull(user1);
            //调用方法删除
            Assert.assertEquals(1, userMapper.deleteById(1L));
            //再次查询，这时应该没有值为null
            Assert .assertNull(userMapper.selectById(1L));
            //使用 SysUser 参数再进行一次测试，根据 id = 1001 查询
            SysUser user2 = userMapper.selectById(1001L);
            //现在还能查询出 user 对象
            Assert.assertNotNull(user2);
            //调用方法删除，注意这里使用参数user2
            Assert.assertEquals(1, userMapper.deleteById(user2));
            //再次查询，这时应该没有值为null
            Assert.assertNull(userMapper.selectById(1001L));
            // 使用 SysUser 参数再进行一次测试
        } finally {
            //为了不影响测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }
}
