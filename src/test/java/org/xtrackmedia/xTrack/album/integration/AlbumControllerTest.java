package org.xtrackmedia.xTrack.album.integration;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.xtrackmedia.xTrack.album.AlbumController;
import org.xtrackmedia.xTrack.album.AlbumService;

//TODO: Backport these tests to DTO once they are fully implemented
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class AlbumControllerTest {

    @Autowired
    private AlbumController albumController;

    @Autowired
    private AlbumService albumService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;


    /*@Test
    public void getAllAlbums_ReturnsOk() throws Exception {
        when(albumService.getAllAlbums()).thenReturn(Arrays.asList(
                new AlbumDTO("Album1", "Artist1", 2020, "Rock"),
                new AlbumDTO("Album2", "Artist2", 2021, "Pop")
        ));

        mockMvc.perform(get("/album"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$[0].title").value("Album1"))
                .andExpect((ResultMatcher) jsonPath("$[1].title").value("Album2"));
    }
    @Test
    public void getAlbumById_ReturnsOk() throws Exception {
        when(albumService.getAlbumById(1L)).thenReturn(java.util.Optional.of(new AlbumDTO("Album1", "Artist1", 2020, "Rock")));

        mockMvc.perform(get("/album/1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$.title").value("Album1"));
    }*/
}
