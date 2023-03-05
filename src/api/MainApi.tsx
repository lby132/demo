import instance from "./axios";
import jsonInstance from "./jsonAxios";
export {}

export const MainApi = {
    getBoardList: () => instance.get("/board/getBoardList"),
    getContent: (id: number | undefined) => instance.get("/board/getBoardDetail/" + id),
    postUpdate: (data: any) => jsonInstance.post("/board/boardUpdate", data),
    postDelete: (id: number | undefined) => instance.post("/board/boardDelete/" + id),
};