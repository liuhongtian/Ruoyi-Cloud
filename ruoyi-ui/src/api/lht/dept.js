import request from '@/utils/request'

// 查询部门列表
export function listDept(query) {
  return request({
    url: '/lht/ldept/list',
    method: 'get',
    params: query
  })
}

// 查询部门详细
export function getDept(deptId) {
  return request({
    url: '/lht/ldept/' + deptId,
    method: 'get'
  })
}

// 新增部门
export function addDept(data) {
  return request({
    url: '/lht/ldept',
    method: 'post',
    data: data
  })
}

// 修改部门
export function updateDept(data) {
  return request({
    url: '/lht/ldept',
    method: 'put',
    data: data
  })
}

// 删除部门
export function delDept(deptId) {
  return request({
    url: '/lht/ldept/' + deptId,
    method: 'delete'
  })
}
