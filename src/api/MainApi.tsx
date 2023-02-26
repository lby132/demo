import instance from "./axios";

export const MainApi = {
    getBoardList: () => instance.get("/board/getBoardList"),
    getContent: (id: number | undefined) => instance.get("/board/getBoardDetail/" + id),
};