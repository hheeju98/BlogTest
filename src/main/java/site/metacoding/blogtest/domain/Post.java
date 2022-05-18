package site.metacoding.blogtest.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터 쓸때 사용
    private String content; // 섬머노트라는 라이브러리 <htm>태그가 섞여서 디자인이 됨.

    @ColumnDefault("0") // int라서 홑따옴표 필요없음
    private int count; // 조회수

    @ManyToOne(fetch = FetchType.EAGER) // user, userId의 연관관계 만들어줌 / Many = Board, User = One 한명의 유저가 여러개의 게시글
    @JoinColumn(name = "userId") // 디비에 만드렁질때 userId라는 이름으로 만들어줄것임
    private User user; // 디비는 오브젝트를 저장할 수 없다 그래서 fk 사용 / 자바는 오브젝트를 저장할 숭 있다.

    @CreationTimestamp // 데이터가 인서트나 업데이트될때 자동으로 값이 들어감
    private Timestamp createDate;

}
