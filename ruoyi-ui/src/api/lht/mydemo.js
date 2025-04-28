import request from '@/utils/request'

// 查询生成样例列表
export function listMydemo(query) {
  return request({
    url: '/lht/mydemo/list',
    method: 'get',
    params: query
  })
}

// 查询生成样例详细
export function getMydemo(id) {
  return request({
    url: '/lht/mydemo/' + id,
    method: 'get'
  })
}

// 新增生成样例
export function addMydemo(data) {
  return request({
    url: '/lht/mydemo',
    method: 'post',
    data: data
  })
}

// 修改生成样例
export function updateMydemo(data) {
  return request({
    url: '/lht/mydemo',
    method: 'put',
    data: data
  })
}

// 删除生成样例
export function delMydemo(id) {
  return request({
    url: '/lht/mydemo/' + id,
    method: 'delete'
  })
}
