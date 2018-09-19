package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public interface UserMapper {

    /**
     * 通过id查询用户
     */
    SysUser selectById(Long id);

    /**
     * 查找所有用户
     * @return List<SysUser>
     */
    List<SysUser> selectAll();

    /**
     * 根据用户id查询角色信息
     * @param userId 用户id
     * @return List<Role>
     */
    List<SysRole> selectRoleByUserId(Long userId);
}