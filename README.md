# TodoList
| API | HTTP 메서드 | URI | 
|----|------------|------------|
| **할 일 목록 조회** | GET | `/todos` |
| **할 일 상세 조회** | GET | `/todos/{id}` |
| **할 일 생성** | POST | `/todos` |
| **할 일 수정** | PUT | `/todos/{id}` |
| **할 일 삭제** | DELETE | `/todos/{id}` |
| **댓글 목록 조회** | POST | `/todos/{id}/comments` |
| **댓글 조회** | POST | `/todos/{id}/comments/{commentId}` |
| **댓글 생성** | POST | `/todos/{id}/comments` |
| **댓글 수정** | PUT | `/comments/{commentId}` |
| **댓글 삭제** | DELETE | `/comments/{commentId}` |
