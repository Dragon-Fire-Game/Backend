package com.dragong.dragong.domain.member.entity;

import com.dragong.dragong.global.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class MemberInfo extends BaseTimeEntity {

    @Id
    private UUID memberId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column
    private String nickname;

    @Column(columnDefinition = "int default 0")
    private int coin;

    @Column(columnDefinition = "int default 1")
    private int tower;

    @Column
    private Boolean isConnecting;

    @Column
    private String introduction;

    @Builder
    public MemberInfo(Member member, String nickname) {
        this.member = member;
        this.nickname = nickname;
    }

    @Builder(builderMethodName = "updateNicknameBuilder")
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    @Builder(builderMethodName = "updateTowerBuilder")
    public void updateTower() {
        this.tower += 1;
    }

    public void updateCoin(int coin) {
        this.coin += coin;
    }

    public void updateIsConnecting(boolean isConnecting) {
        this.isConnecting = isConnecting;
    }

    public void updateIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
