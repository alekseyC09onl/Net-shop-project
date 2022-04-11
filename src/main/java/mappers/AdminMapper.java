package mappers;

import dto.AdminDTO;
import entity.Admin;

public class AdminMapper {
    public static AdminDTO mapAdminToAdminDTO(Admin admin) {
        return AdminDTO.builder()
                .email(admin.getEmail())
                .name(admin.getName())
                .build();
    }

    public static Admin mapAdminDTOToAdmin(AdminDTO adminDTO) {
        return Admin.builder()
                .email(adminDTO.getEmail())
                .name(adminDTO.getName())
                .build();
    }
}
