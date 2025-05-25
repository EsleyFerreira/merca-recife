package br.edu.uniaeso.merca_recife.mapper;

import br.edu.uniaeso.merca_recife.dto.MerchantDTO;
import br.edu.uniaeso.merca_recife.entity.Merchant;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MerchantMapper {

    public static MerchantDTO toDTO(Merchant merchant) {
        if (merchant == null) {
            return null;
        }
        MerchantDTO dto = new MerchantDTO();
        dto.setId(merchant.getId());
        dto.setName(merchant.getName());
        dto.setCpf(merchant.getCpf());
        dto.setEmail(merchant.getEmail());
        dto.setContact(merchant.getContact());
        dto.setApproved(merchant.isApproved());

        if (merchant.getOwnedBoxes() != null) {

            dto.setOwnedBoxes(
                    merchant.getOwnedBoxes().stream()
                            .map(BoxMapper::toDTO)
                            .collect(Collectors.toList())
            );
        } else {
            dto.setOwnedBoxes(new ArrayList<>());
        }
        return dto;
    }

    public static Merchant toEntity(MerchantDTO dto) {
        if (dto == null) {
            return null;
        }
        Merchant merchant = new Merchant();
        merchant.setId(dto.getId());
        merchant.setName(dto.getName());
        merchant.setCpf(dto.getCpf());
        merchant.setEmail(dto.getEmail());
        merchant.setContact(dto.getContact());
        merchant.setApproved(dto.isApproved());

        if (dto.getOwnedBoxes() != null) {

            merchant.setOwnedBoxes(
                    dto.getOwnedBoxes().stream()
                            .map(BoxMapper::toEntity)
                            .collect(Collectors.toList())
            );
        }
        return merchant;
    }
}
