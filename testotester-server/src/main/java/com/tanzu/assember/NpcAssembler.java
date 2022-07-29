package com.tanzu.assember;

import com.tanzu.controller.NpcController;
import com.tanzu.entity.npc.MajorNpc;
import com.tanzu.entity.npc.Npc;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class NpcAssembler implements RepresentationModelAssembler<Npc, EntityModel<Npc>> {
    @Override
    public EntityModel<Npc> toModel(Npc npc) {
        EntityModel<Npc> npcModel = EntityModel.of(npc,
                linkTo(methodOn(NpcController.class).single(npc.getNpcID())).withSelfRel());

        return npcModel;
    }

    public URI toURI(Npc npc) {
        return linkTo(methodOn(NpcController.class).single(npc.getNpcID())).toUri();
    }
}
