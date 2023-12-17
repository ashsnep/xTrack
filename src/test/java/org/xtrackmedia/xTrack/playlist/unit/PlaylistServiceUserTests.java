package org.xtrackmedia.xTrack.playlist.unit;

//@ExtendWith(MockitoExtension.class)
public class PlaylistServiceUserTests {
//    @Mock
//    private PlaylistRepository playlistRepository;
//
//    @InjectMocks
//    private PlaylistService playlistService;
//
//    @Test
//    void savePlaylist() {
//        User user = new User("Test User", "Test Password", "Test Email");
//        PlaylistDTO playlistDTO = new PlaylistDTO(1L, "Test Playlist", user, null);
//        Playlist playlist = PlaylistConverter.ToEntity(playlistDTO);
//
//        when(playlistRepository.save(Mockito.any(Playlist.class))).thenReturn(playlist);
//
//        PlaylistDTO savedPlaylistDTO = playlistService.savePlaylist(playlistDTO);
//
//        assertEquals(playlistDTO.getId(), savedPlaylistDTO.getId());
//        assertEquals(playlistDTO.getTitle(), savedPlaylistDTO.getTitle());
//        assertEquals(playlistDTO.getUser(), savedPlaylistDTO.getUser());
//        assertEquals(playlistDTO.getSongList(), savedPlaylistDTO.getSongList());
//    }
//
//    @Test
//    void getPlaylistById() {
//        long playlistId = 1L;
//        Playlist playlist = new Playlist(playlistId, "Test Playlist", null, null);
//        when(playlistRepository.findById(playlistId)).thenReturn(Optional.of(playlist));
//
//        Optional<PlaylistDTO> playlistDTO = playlistService.getPlaylistById(playlistId);
//
//        assertTrue(playlistDTO.isPresent());
//        assertEquals(playlist.getId(), playlistDTO.get().getId());
//        assertEquals(playlist.getTitle(), playlistDTO.get().getTitle());
//        assertEquals(playlist.getUser(), playlistDTO.get().getUser());
//        assertEquals(playlist.getSongList().size(), playlistDTO.get().getSongList().size());
//    }
}
